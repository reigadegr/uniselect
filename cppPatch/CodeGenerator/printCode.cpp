#include <fstream>
#include <iostream>
#include <vector>

#include "include/LOG.h"
#include "include/class.h"
auto runTypeCasting(const std::string &type, std::vector<mapping> &typeCasting)
    -> std::string;
auto printEntity(std::string &className,
                 std::vector<dbAttribute> &NameAndAttribute,
                 std::vector<mapping> &typeCasting) -> void
{
    LOG("//这是 ", className, ".java", "\n");
    LOG("import lombok.AllArgsConstructor;");
    LOG("import lombok.Data;");
    LOG("import lombok.NoArgsConstructor;\n");
    LOG("@Data");
    LOG("@AllArgsConstructor");
    LOG("@NoArgsConstructor\n");

    LOG("public class ", className, "{");

    for (const auto &tmp : NameAndAttribute) {
        const std::string newtype = runTypeCasting(tmp.type, typeCasting);
        LOG("    private ", newtype, " ", tmp.name, ";");
    }
    LOG("}");
    LOG("//-----------------结束----------------");
    LOG("\n");
}

auto printMapperInterface(std::string &className,
                          std::vector<dbAttribute> &NameAndAttribute,
                          std::vector<mapping> &typeCasting) -> void
{
    std::string orgClassName = className;
    orgClassName[0] = std::tolower(orgClassName[0]);
    LOG("//这是 ", className, "Mapper.java", "\n");
    LOG("import org.apache.ibatis.annotations.Mapper;");
    LOG("import org.apache.ibatis.annotations.Param;");
    LOG("import org.apache.ibatis.annotations.Select;\n");
    LOG("@Mapper");
    LOG("public interface " + className + "Mapper {");
    LOG("    @Select(\"SELECT * FROM ", orgClassName, " WHERE ", orgClassName,
        "_id = #{", orgClassName, "Id} AND password = #{password}\")");

    LOG("    ", className + " findBy" + className + "IdAndPassword",
        "(@Param(\"", orgClassName, "Id\") String ", orgClassName,
        "Id, @Param(\"password\") String password);");
    LOG("}");
    LOG("//-----------------结束----------------");
    LOG("\n");
}

auto printServiceInterface(std::string &className,
                           std::vector<dbAttribute> &NameAndAttribute,
                           std::vector<mapping> &typeCasting) -> void
{
    std::string orgClassName = className;
    orgClassName[0] = std::tolower(orgClassName[0]);
    LOG("//这是 ", className, "Service.java", "\n");
    LOG("public interface " + className, "Service {");
    LOG("    public ", className, " ", "findBy", className,
        "IdAndPassword(String ", orgClassName, "Id, String password);");
    LOG("}");
    LOG("//-----------------结束----------------");
    LOG("\n");
}

auto printServiceClass(std::string &className,
                       std::vector<dbAttribute> &NameAndAttribute,
                       std::vector<mapping> &typeCasting) -> void
{
    std::string orgClassName = className;
    orgClassName[0] = std::tolower(orgClassName[0]);
    LOG("//这是 ", className, "ServiceImpl.java", "\n");
    LOG("import org.springframework.beans.factory.annotation.Autowired;");
    LOG("import org.springframework.stereotype.Service;\n");
    LOG("@Service");
    LOG("public class ", className, "ServiceImpl implements ", className,
        "Service {");
    LOG("    @Autowired");
    LOG("    private ", className, "Mapper ", orgClassName, "Mapper;\n");

    LOG("    @Override");
    LOG("    public ", className, " findBy", className, "IdAndPassword(String ",
        orgClassName, "Id, String password) {");
    LOG("        return ", orgClassName, "Mapper.findBy", className,
        "IdAndPassword(", orgClassName, "Id, password);");
    LOG("    }");
    LOG("}");
    LOG("//-----------------结束----------------");
    LOG("\n");
}
auto printController(std::string &className,
                     std::vector<dbAttribute> &NameAndAttribute,
                     std::vector<mapping> &typeCasting) -> void
{
    std::string orgClassName = className;
    orgClassName[0] = std::tolower(orgClassName[0]);
    LOG("//这是 ", className, "Controller.java", "\n");
    LOG("import org.springframework.beans.factory.annotation.Autowired;");
    LOG("import org.springframework.web.bind.annotation.CrossOrigin;");
    LOG("import org.springframework.web.bind.annotation.RequestBody;");
    LOG("import org.springframework.web.bind.annotation.RequestMapping;");
    LOG("import org.springframework.web.bind.annotation.RestController;\n");
    LOG("@RestController");
    LOG("public class ", className, "Controller {");
    LOG("   @Autowired");
    LOG("   private ", className, "Service ", orgClassName, "Service;\n");
    LOG("   @CrossOrigin(origins = \"*\")");
    LOG("   @RequestMapping(\"/", orgClassName, "loginverify\")");
    LOG("   public ", className, " findBy", className,
        "IdAndPassword(@RequestBody ", className, " ", orgClassName, ") {");
    LOG("       String ", orgClassName, "_id = ", orgClassName, ".get",
        className, "_id();");
    LOG("       String password = ", orgClassName, ".getPassword();");
    LOG("       return ", orgClassName, "Service.findBy", className,
        "IdAndPassword(", orgClassName, "_id, password);\n   }");
    LOG("}");
    LOG("//-----------------结束----------------");
    LOG("\n");
}
