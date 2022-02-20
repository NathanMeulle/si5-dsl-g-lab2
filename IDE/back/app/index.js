const express = require('express');
const session = require('express-session');
const api = require('./api');
const cors = require('cors')
const session_manager = require('./session')
const dotenv = require('dotenv')

dotenv.config();
const app = express();
const portREST = 8080;

/* prevent of cross-origin issue */
app.use(cors({
  origin: [`http://${process.env.FRONT_HOST}`],
  credentials: true
}));

/* enable sessions */
app.use(session({
  secret: 'dsl-ide',
  resave: false,
  saveUninitialized: false,
  cookie: { secure: false, maxAge: session_manager.maxTime }
}))


/* send json data by default */
app.use(express.json());
app.use('/dsl-api', api);
app.listen(portREST, () => console.log('Listening REST API on port '+portREST+'!'))