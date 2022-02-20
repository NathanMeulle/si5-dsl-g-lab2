FROM node:lts-alpine

# définit le dossier 'app' comme dossier de travail
WORKDIR /app

RUN apk add openjdk11
RUN apk add maven

COPY DSL/core core
RUN mvn -f core clean install 

COPY DSL/generator generator
RUN mvn -f generator clean install 

COPY DSL/parser parser
RUN mvn -f parser clean install 

COPY IDE/docker/run.sh run.sh

RUN mkdir output
RUN mkdir output/src

# copie 'package.json' et 'package-lock.json' (si disponible)
COPY output/package*.json ./output

# installe les dépendances du projet
RUN npm install --prefix ./output/



# copie les fichiers et dossiers du projet dans le dossier de travail (par exemple : le dossier 'app')
COPY output/src ./output/src

EXPOSE 8080
CMD [ "npm", "run", "serve", "--prefix", "./output" ]