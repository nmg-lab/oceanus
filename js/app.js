var express = require('express'); //erpress 框架引入
var app = express();
var fs = require('fs');
var bodyParser = require('body-parser'); 
var mysql = require('mysql');
var urlencodeParser = bodyParser.urlencoded({
	extended: true
});
var connection = mysql.createConnection({
	host: '127.0.0.1',
	user: 'root',
	password: '',
	database: 'student'
});
app.use(express.static('C:\\Users\\79263\\Desktop\\holiday'));
app.get('/index.html',(req,res)=>{
	res.send(_dirname+"/"+"index.html");
});
var server = app.listen(3000,()=>{
	var host = server.address().address;
	var port = server.address().port;
	console.log('Example app listening at http://%s:%s', host, port);
});
app.post('/login', urlencodeParser, function(req, res) { //用户登陆逻辑
	var response = {
		userName: req.body.userAccount,
		password: req.body.password
	};
	var rp = response;
	connection.query("select * from userinformation where user_name='" + rp.userName + "' and password='" + rp.password + "'", function(err, result) {
		if(err) {
			console.log(err.message);
		}
		console.log(JSON.stringify(result));
		res.json(JSON.stringify(result));
		return result;
	});
});
app.post('/register',urlencodeParser,function(req,res){
	var response = {
		id:null,
		userFirstname:req.body.username,
		user_name:req.body.account,
		password: req.body.password,
		Email: req.body.email
	}
	connection.query("insert into userinformation set ?",response,function(err,result){
		if(err) {
			console.log(err.message);
		}
		console.log(JSON.stringify(result));
		res.json(JSON.stringify(result));
		return result;
	})
})

