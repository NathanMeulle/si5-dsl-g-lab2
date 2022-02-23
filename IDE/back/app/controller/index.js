const docker = require('../docker')

function render(uuid, code){
    docker.updateCode(uuid, code)
}

module.exports = {
    render
}