const { Router } = require('express');
const router = new Router();
const Controller = require('../controller');
const session_manager = require('../session')
const uuid = require('uuid');

router.post('/login', (req, res) => {

    var json
    if(req.session.uuid === undefined){
        req.session.uuid = uuid.v1();
        json = session_manager.startSession(req.session.uuid)
    }
    else{
        json = session_manager.refreshSession(req.session.uuid)
    }
    res.send(json)
})

router.post('/render', (req, res) => {

    var json
    if(req.session.uuid === undefined){
        console.log('session expired')
        json = {error: 'session expired'}
    }
    else{
        req.session.touch()
        json = session_manager.refreshSession(req.session.uuid)
        
        const code = req.body.code
        const render = Controller.render(req.session.uuid, code);
        json.errors = render.errors
        json.output = render.output
    }
    
    res.send(json)
});

module.exports = router