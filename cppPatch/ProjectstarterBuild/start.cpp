/* Copyright 2024 reigadegr@gitbub.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. */
#include <filesystem>
#include <fstream>
#include <iostream>
#include <thread>
#include <vector>

template <typename... Args>
static void LOG(const Args&... args)
{
    const auto printArg = [&](const auto& arg) { std::cout << arg; };
    (printArg(args), ...);
    std::cout << std::endl;
}

auto oncePrint() -> void
{
    std::puts("Welcome to use projectStarter!");
    std::puts("Project Starter by reigadegr@github");
    std::puts("The software is not allowed for any commercial use");
    std::puts(
        "You can use projectStarter to start your vue project or springboot "
        "project");
    std::puts("\n");
}

namespace fs = std::filesystem;

static inline auto verify_target_file_is_exists(const char* dependency) -> bool
{
    if (!fs::exists(dependency)) {
        LOG("cannot found '", dependency, "': No such file or directory");
        std::puts("\n");
        return false;
    }
    return true;
}

template <typename... Args>
auto clearPath(Args... args) -> bool
{
    std::vector<std::string> need_delete;
    (need_delete.push_back(args), ...);

    for (const auto& tmp : need_delete) {
        LOG(tmp);
        if (fs::exists(tmp) && fs::is_directory(tmp)) {
            fs::remove_all(tmp);
            LOG(tmp, " is already cleared.");
        }
    }

    return true;
}

#if defined(_WIN32)
const std::string yarn = "yarn.cmd";
#elif defined(__linux__)
const std::string yarn = "yarn";
#endif

auto determineStrExists(const char* inputFile, const char* str) -> bool
{
    std::ifstream file(inputFile);
    std::string buf;
    while (std::getline(file, buf)) {
        if (buf.find(str) == std::string::npos) {
            continue;
        }
        file.close();
        // std::puts("不为空，升级");
        // system((yarn + " upgrade " + str).c_str());
        return true;
    }
    file.close();

    LOG("检测到", str, "未安装，开始安装");
    system((yarn + " add " + str).c_str());
    return false;
}

auto vue_projectStart(const char* dependency) -> bool
{
    if (bool is_exists = verify_target_file_is_exists(dependency); !is_exists) {
        return false;
    }
    std::puts("Please make sure you have installed Node.js.");

// init yarn tools
#if defined(_WIN32)
    system("yarn.cmd --version || npm install -g yarn");
#elif defined(__linux__)
    system("yarn --version || pkg install yarn");
#endif
    system((yarn + " config set strict-ssl false").c_str());
    // change repo
    // yarn config set registry https://registry.npm.taobao.org/
    // yarn config set registry https://registry.npmjs.org/
    system((yarn + " config set registry https://registry.npm.taobao.org")
               .c_str());
    system((yarn + " install").c_str());
    // add some packages
    determineStrExists("package.json", "element-plus");
    determineStrExists("package.json", "axios");
    determineStrExists("package.json", "vue-router");

    system((yarn + " serve || " + yarn + " dev || " + yarn +
            " global add @vue/cli && " + yarn + " serve || " + yarn + " dev")
               .c_str());
    // clearPath("node_modules");
    return true;
}

auto springboot_projectStart(const char* dependency) -> bool
{
    if (bool is_exists = verify_target_file_is_exists(dependency); !is_exists) {
        return false;
    }
    std::puts("Please make sure you have installed maven.");
    system("mvn clean install");
    system("mvn spring-boot:run");
    return true;
}

auto AutoDetermine() -> bool
{
    if (fs::exists("pom.xml")) {
        springboot_projectStart("pom.xml");
        return true;
    }
    if (fs::exists("package.json")) {
        vue_projectStart("package.json");
        return true;
    }
    return false;
}

auto scanFile() -> bool
{
    if ((!fs::exists("pom.xml")) && (!fs::exists("package.json"))) {
        std::puts("Not found springboot and vue dependency file,");
        std::puts("Please make sure you have location in target directory.");
        std::puts("Press any keys to exit.");
        std::cin.get();
        return false;
    }
    return true;
}

auto main(int argc, char** argv) -> int
{
    oncePrint();

    if (bool TureDirectory = scanFile(); !TureDirectory) {
        return 2;
    }
    AutoDetermine();

    std::puts("Maybe has some error,please try again");
    std::cin.get();
}
