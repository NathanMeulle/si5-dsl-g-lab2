mvn -f DSL/core clean install
mvn -f DSL/generator clean install
mvn -f DSL/parser clean install

mvn -f DSL/parser exec:java -Dexec.args="DSL/parser/src/main/resources/basic.cml"

mvn -f DSL/core clean 
mvn -f DSL/parser clean 
mvn -f DSL/generator clean

npm install --prefix IDE/front
npm install --prefix IDE/back

docker build -t dsl -f IDE/docker/Dockerfile .