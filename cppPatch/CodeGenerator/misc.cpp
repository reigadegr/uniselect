#include <fstream>
#include <iostream>
#include <vector>

#include "include/LOG.h"
#include "include/class.h"
auto getStr(std::string &buf, std::string &className,
            std::vector<dbAttribute> &NameAndAttribute) -> void;
auto initTypeCasting(std::vector<mapping> &typeCasting) -> void
{
    typeCasting.push_back({"VARCHAR", "String"});
    typeCasting.push_back({"varchar", "String"});
    typeCasting.push_back({"int", "Integer"});
    typeCasting.push_back({"INT", "Integer"});
}
auto getStr(std::string &buf, std::string &className,
            std::vector<dbAttribute> &NameAndAttribute) -> void
{
    if (buf.find('`') == std::string::npos) {
        return;
    }
    size_t start = buf.find('`');
    std::string name;

    // 找到第二个反引号的位置
    size_t end = buf.find('`', start + 1);

    // 提取反引号中的字符
    name = buf.substr(start + 1, end - start - 1);
    if (buf.find("CREATE TABLE") != std::string::npos) {
        className = name;
        // 首字母变大写
        className[0] = toupper(className[0]);
        // LOG("//类名: ", className, "类名结束");
    }
    buf.erase(0, end + 2);
    // 获取字段类型
    size_t left = buf.find('(');
    std::string type = buf.substr(0, left);
    if (type != "") {
        NameAndAttribute.push_back({name, type});
    }

    return;
}
auto readProfile(const char *inputFile, std::string &className,
                 std::vector<dbAttribute> &NameAndAttribute) -> void
{
    std::ifstream file(inputFile);
    std::string buf;
    while (std::getline(file, buf)) {
        if (buf[0] == '#') {
            continue;
        }
        getStr(buf, className, NameAndAttribute);
    }
    file.close();
    return;
}

auto runTypeCasting(const std::string &type, std::vector<mapping> &typeCasting)
    -> std::string
{
    const char *constCharType = type.c_str();
    for (const auto &tmp : typeCasting) {
        if (strcmp(constCharType, tmp.dbType.c_str()) == 0) {
            return tmp.javaType;
        }
    }
    return type;
}
