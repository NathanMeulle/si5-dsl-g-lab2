const docker = require('../docker')

const maxTime = 300000
const sessions = {}

function startSession(uuid){

    console.log(`Starting a new session for : ${uuid}`)
    sessions[uuid] = setTimeout(()=>endingSession(uuid), maxTime)

    const port = docker.start(uuid)
    const code = docker.getCode(uuid)
    const session_info = {session_time: maxTime, session_port: port, code: code, new_session: true}
    return session_info
}

function refreshSession(uuid){

    console.log(`Refreshing session for : ${uuid}`)
    clearTimeout(sessions[uuid]);
    sessions[uuid] = setTimeout(()=>endingSession(uuid), maxTime)

    const port = docker.dockers[uuid]
    const code = docker.getCode(uuid)
    const session_info = {session_time: maxTime, session_port: port, code: code, new_session: false}
    return session_info
}

function endingSession(uuid){
    
    if(uuid !== undefined && sessions[uuid] !== undefined){
        console.log(`Ending session for : ${uuid}`)
        delete sessions[uuid]
        docker.stop(uuid)
    }
}

module.exports = {
    maxTime,
    startSession,
    refreshSession,
}