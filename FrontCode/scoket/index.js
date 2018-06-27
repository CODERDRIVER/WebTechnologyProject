//使用express模块快速搭建web服务器
var express = require('express');
var app = express();
var http = require('http').Server(app);
//使用socket.io监听事件
var io = require('socket.io')(http);
//使用express发送css js等静态资源
app.use(express.static('public'));

//express获得GET请求时将index.html文件返回给浏览器
app.get('/', function(req, res) {
    res.sendFile(__dirname + "/index.html");
});

//socket监听连接事件
io.on('connection', function(socket) {
    console.log('一个用户上线了');
    //socket监听失去连接的事件
    socket.on('disconnect', function() {
        console.log('一个用户下线了');
    });

    //当socket监听到了'chat message'事件
    socket.on('chat message', function(msg) {
        //将收到的信息返回给所有客户端
        io.emit('chat message', msg);
    });

});

//服务器监听端口3000
http.listen(3000, function() {
    console.log('listening on *:3000');
})