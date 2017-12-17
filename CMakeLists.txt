cmake_minimum_required(VERSION 3.9)
project(Contest)

set(CMAKE_CXX_STANDARD 17)

file(GLOB_RECURSE SRC_FILES src-cpp/*.cpp)
add_executable(src-cpp ${SRC_FILES})