var express=require("express");
var app = express();
var server = require("http").createServer(app);
var io = require("socket.io").listen(server);
var fs = require("fs");
server.listen(process.env.PORT||3000);

console.log("Server running");
var arrayUser = [];
var tontai = true;
io.sockets.on('connection',function(socket){
	console.log("Co thiet bi vua ket noi");
	socket.on('client-register-user', function(data){
		if(arrayUser.indexOf(data)==-1){
			arrayUser.push(data);
			tontai=false;
			console.log("Dang ky thanh cong user:"+data);
			socket.un=data;
			io.sockets.emit('server-send-user', {danhsach: arrayUser});
		}else{
			console.log("Da ton tai user:"+data);
			tontai=true;
		}
		io.sockets.emit('server-send-data',{ketqua: tontai});
	});
	socket.on('client-send-chat',function(noiDung){
		console.log(socket.un+":"+noiDung, { chatComent: socket.un+":"+noiDung});

		io.sockets.emit('server-send-chat',{chatComent: socket.un+":"+noiDung});
		//console.log(result)
	});
});


