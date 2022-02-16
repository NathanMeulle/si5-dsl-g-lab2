const { Router } = require('express');
const router = new Router();
const Controller = require('../controller');


router.post('/render', (req, res) => {
    const code = req.body.code
    Controller.render(code);
    res.sendStatus(200);
});

module.exports = router