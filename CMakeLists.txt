cmake_minimum_required(VERSION 3.9)
project(Contest)

set(CMAKE_CXX_STANDARD 17)

file(GLOB_RECURSE SRC_FILES src-cp/*.cpp)
add_executable(src-cp ${SRC_FILES})