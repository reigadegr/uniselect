#include <fstream>
#include <iostream>
#include <vector>

#include "include/LOG.h"
#include "include/class.h"
auto readProfile(const char *inputFile, std::string &className,
                 std::vector<dbAttribute> &NameAndAttribute) -> void;
auto runTypeCasting(const std::string &type, std::vector<mapping> &typeCasting)
    -> std::string;
auto initTypeCasting(std::vector<mapping> &typeCasting) -> void;
auto printEntity(std::string &className,
                 std::vector<dbAttribute> &NameAndAttribute,
                 std::vector<mapping> &typeCasting) -> void;
auto printMapperInterface(std::string &className,
                          std::vector<dbAttribute> &NameAndAttribute,
                          std::vector<mapping> &typeCasting) -> void;
auto printServiceInterface(std::string &className,
                           std::vector<dbAttribute> &NameAndAttribute,
                           std::vector<mapping> &typeCasting) -> void;
auto printServiceClass(std::string &className,
                       std::vector<dbAttribute> &NameAndAttribute,
                       std::vector<mapping> &typeCasting) -> void;
auto printController(std::string &className,
                     std::vector<dbAttribute> &NameAndAttribute,
                     std::vector<mapping> &typeCasting) -> void;
#if 0

#endif
auto printAnyJava(std::string &className,
                  std::vector<dbAttribute> &NameAndAttribute,
                  std::vector<mapping> &typeCasting) -> void
{
    // 生成实体类
    printEntity(className, NameAndAttribute, typeCasting);
    // 生成mapper接口
    printMapperInterface(className, NameAndAttribute, typeCasting);
    // 生成service接口
    printServiceInterface(className, NameAndAttribute, typeCasting);
    // 生成service接口实现类
    printServiceClass(className, NameAndAttribute, typeCasting);
    // 生成cotroller
    printController(className, NameAndAttribute, typeCasting);
}
auto main(int argc, char **argv) -> int
{
    if (argv[1] == nullptr) {
        LOG("没输入命令行参数");
        return 2;
    }
    std::string className = "";
    std::string orgClassName = "";
    std::vector<dbAttribute> NameAndAttribute;
    std::vector<mapping> typeCasting;
    LOG("//开始生成...");
    initTypeCasting(typeCasting);
    // 读取建表命令
    readProfile(argv[1], className, NameAndAttribute);

    printAnyJava(className, NameAndAttribute, typeCasting);
}
