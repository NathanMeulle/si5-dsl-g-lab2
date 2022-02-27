const { execSync, exec } = require('child_process');
const fs = require('fs');

const dockers = {}

function start(uuid){

    let port = 8082;
    while(Object.values(dockers).includes(port)) port++;
    dockers[uuid] = port;
    execSync(`docker run -d --name ${uuid} -p ${port}:8080 dsl`)
    return port
}

function stop(uuid){
    
    execSync(`docker stop ${uuid}`)
    setTimeout(async () => await execSync(`docker rm ${uuid}`), 5000)
    
    delete dockers[uuid]
}

function updateCode(uuid, arg){

    let err = fs.writeFileSync(`${uuid}.cml`, arg)
    if(err) return 1
    else {
        execSync(`docker cp ${uuid}.cml ${uuid}:/app/parser/src/main/resources/basic.cml`)
        execSync(`rm ${uuid}.cml`)
        execSync(`docker exec ${uuid} ./run.sh`)
    }
}

function getCode(uuid){
    return execSync(`docker exec ${uuid} cat parser/src/main/resources/basic.cml`).toString()
}

module.exports = {
    start,
    stop, 
    updateCode,
    getCode,
    dockers
}