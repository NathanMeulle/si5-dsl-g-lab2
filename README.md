<p align="center">
  <h1 align="left">SI5 DSL - lab2</h3>
  <p align="left">
  Team G
   <br />
   <a href="https://github.com/Martin-Bruel">Bruel Martin</a>,
   <a href="https://github.com/Thibaut-Esteve">Esteve Thibaut</a>,
   <a href="https://github.com/DavidLebrisse">Lebrisse David</a>,
   <a href="https://github.com/NathanMeulle">Meulle Nathan</a>,	
   <a href="https://github.com/kevinushaka">Ushaka Kevin</a>,
   <br /><br />
  </p>
  <p align="center">
</p>

# Choix

## Framework Front
Nous avons choisi d'utiliser [Bootstrap Vue](https://bootstrap-vue.org/docs/components)


# Installation

Toutes les commandes sont à réaliser à la racine du projet

## Prérequis

docker  
npm  
maven  
java 11  

## Compilation

Si l'application n'est pas lancée en local, adapter les fichiers [IDE/front/.env](IDE/front/.env) et [IDE/back/.env](IDE/back/.env)  

### Sans IDE

Exécutez le script ```./build.sh```

### Avec IDE

Exécutez le script ```./build_ide.sh```

## Exécution

### Sans IDE

Exécutez la commande ```mvn -f DSL/parser exec:java -Dexec.args="DSL/parser/src/main/resources/basic.cml"```

### Avec IDE

Exécutez le script pour lancer le back ```cd IDE/back && npm start```  puis    
le front ```cd IDE/front && npm start```
