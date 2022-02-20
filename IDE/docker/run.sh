#!/bin/sh
cd parser
java -classpath target/classes:/root/.m2/repository/com/polytech/si5-dsl-g/core/1.0-SNAPSHOT/core-1.0-SNAPSHOT.jar:/root/.m2/repository/com/polytech/si5-dsl-g/generator/1.0/generator-1.0.jar:/root/.m2/repository/org/antlr/antlr4-runtime/4.7/antlr4-runtime-4.7.jar Main src/main/resources/basic.cml