const { Router } = require('express');
const router = new Router();
const Controller = require('../controller');
const session_manager = require('../session')

router.post('/login', (req, res) => {

    var json = session_manager.startSession(req.session)
    res.send(json)
})

router.post('/render', (req, res) => {

    var json
    if(req.session.uuid === undefined){
        console.log('session expired')
        json = {error: 'session expired'}
    }
    else{        
        const code = req.body.code
        const render = Controller.render(req.session.uuid, code);
        json = session_manager.refreshSession(req.session)
        json.errors = render.errors
        json.output = render.output
    }
    
    res.send(json)
});

module.exports = router