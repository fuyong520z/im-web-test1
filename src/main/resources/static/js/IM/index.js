var data = {};
// 注意这里, 引入的 SDK 文件不一样的话, 你可能需要使用 SDK.NIM.getInstance 来调用接口
var nim = NIM.getInstance({
    // debug: true,
    appKey: 'd1335702c5181eda4cb43612c68ede91',
    account: '713af609238332a6a23deb0fa2ef60f7',
    token: '60215095799d97fbfcbcb681a5ffbc24',
    // privateConf: {}, // 私有化部署方案所需的配置
    onconnect: onConnect,
    onwillreconnect: onWillReconnect,
    ondisconnect: onDisconnect,
    onerror: onError,
    // 消息
    onroamingmsgs: onRoamingMsgs,
    onofflinemsgs: onOfflineMsgs,
    onmsg: onMsg
});


function requestAjax() {
    $.ajax({
        type: 'post',
        url: '/callable',
        success: function(json){
                console.log(json)
        }
    });

}
function onConnect() {
    console.log('连接成功');
}
function onWillReconnect(obj) {
    // 此时说明 SDK 已经断开连接, 请开发者在界面上提示用户连接已断开, 而且正在重新建立连接
    console.log('即将重连');
    console.log(obj.retryCount);
    console.log(obj.duration);
}
function onDisconnect(error) {
    // 此时说明 SDK 处于断开状态, 开发者此时应该根据错误码提示相应的错误信息, 并且跳转到登录页面
    console.log('丢失连接');
    console.log(error);
    if (error) {
        switch (error.code) {
            // 账号或者密码错误, 请跳转到登录页面并提示错误
            case 302:
                break;
            // 重复登录, 已经在其它端登录了, 请跳转到登录页面并提示错误
            case 417:
                break;
            // 被踢, 请提示错误后跳转到登录页面
            case 'kicked':
                break;
            default:
                break;
        }
    }
}

function onRoamingMsgs(obj) {
    console.log('漫游消息', obj);
    pushMsg(obj.msgs);
}

function onOfflineMsgs(obj) {
    console.log('离线消息', obj);
    pushMsg(obj.msgs);
}

function onMsg(msg) {
    console.log('收到消息', msg.scene, msg.type, msg);
    pushMsg(msg);
    switch (msg.type) {
        case 'custom':
            onCustomMsg(msg);
            break;
        case 'notification':
            // 处理群通知消息
            onTeamNotificationMsg(msg);
            break;
        // 其它case
        default:
            break;
    }
}
function sendMessage() {
   var imagesS = nim.sendText({
        scene: 'p2p',
        to: '1a6d17300fc8635c76113d191592bac1',
        text: 'hello 你好',
        done: sendMsgDone
    })
    console.log('正在发送p2p text消息, id=' + msg.idClient);
    pushMsg(msg);
   /*var imagesS= nim.sendFile({
         scene: 'p2p',
        to: 'fa2ee7250dbc8b40d3341aac579bdfc4',
        type: 'image',
        blob:id,
        fastPass: '{"w":200,"h":110,"md5":'+mdg+'}',
        beginupload: function(upload) {
            // - 如果开发者传入 fileInput, 在此回调之前不能修改 fileInput
            // - 在此回调之后可以取消图片上传, 此回调会接收一个参数 `upload`, 调用 `upload.abort();` 来取消文件上传
        },
        uploadprogress: function(obj) {
            console.log('文件总大小: ' + obj.total + 'bytes');
            console.log('已经上传的大小: ' + obj.loaded + 'bytes');
            console.log('上传进度: ' + obj.percentage);
            console.log('上传进度文本: ' + obj.percentageText);
        },
        uploaddone: function(error, file) {
            console.log(error);
            console.log(file);
            console.log('上传' + (!error?'成功':'失败'));
        },
        beforesend: function(msg) {
            console.log('正在发送p2p image消息, id=' + msg.idClient);
            pushMsg(msg);
        },
        done: sendMsgDone
    });*/

    function sendMsgDone(error, msg) {
        console.log(error);
        console.log(msg);
        console.log('发送' + imagesS.scene + ' ' + imagesS.type + '消息' + (!error?'成功':'失败') + ', id=' + imagesS.idClient);
        pushMsg(msg);
    }
}
function pushMsg(msgs) {
    if (!Array.isArray(msgs)) { msgs = [msgs]; }
    var sessionId = imagesS[0].scene + '-' + msimagesSgs[0].account;
    data.msgs = data.msgs || {};
    data.msgs[sessionId] = nim.mergeMsgs(data.msgs[sessionId], msgs);
}
function onError(error) {
    console.log(error);
}