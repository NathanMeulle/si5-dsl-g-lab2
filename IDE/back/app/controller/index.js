const docker = require('../docker')

function render(uuid, code){
    const output = docker.updateCode(uuid, code)

    const json = {}
    if(output == 1){
        json.output = "docker error..."
    }
    else{
        var error = '[]'
        for(line of output.split('\n')){
            if(line.startsWith('[')) {
                error = line
                break
            }
        }
        
        json.errors = JSON.parse(error)
        json.output = output
    }
    return json
}

module.exports = {
    render
}