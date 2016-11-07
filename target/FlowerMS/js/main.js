//菜单栏点击样式变化
function menuClick(index) {
    var menu = $("#menu-click");
    var lis = menu.children();
    for(var i=0;i<lis.length;i++){
        lis[i].className="btn btn-default";
    }
    lis[index].className="btn btn-default active";
}

function ajaxRefresh(url) {
    $.ajax({
        url:url,
        success:function (html) {
            //alert(html);
            $("#content").html(html);
        }
    });
}

function ajaxForm(url,id){
    var data = id+'='+$('#'+id).val();
    //alert(data);
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(html){
            //alert(html);
            $("#content").html(html);
        }
    });
}

function ajaxFormWorker(url,workerID,workername){
    var data = workerID+'='+$('#'+workerID).val()+'&'+workername+'='+$('#'+workername).val();
    //alert(data);
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(html){
            //alert(html);
            $("#content").html(html);
        }
    });
}

function ajaxFormOrder(url){
    var data = 'orderID='+$('#orderID').val()
        +'&sendMan='+$('#sendMan').val()
        +'&startTime='+$('#startTime').val()
        +'&endTime='+$('#endTime').val()
        +'&saleman='+$('#saleman').val();
    //alert(data);
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function(html){
            //alert(html);
            $("#content").html(html);
        }
    });
}

function refresh(id) {
    var con = $(id).contents();
    $("#content").html(con);
}

var PayState = ["未付款","已付款"];
var SendState = ["未发送","已发送"];
var Status = ["已取消","正在进行中","已完成"];


function loginCheck(){
    var username = $('#username').val();
    var password = $('#password').val();
    if(username==''){
        alert("用户名不能为空");
        return false;
    }
    if(!username.match(/[a-zA-Z0-9_]{4,20}/)){
        alert("用户名必须为4~20位大小写字母数字下划线");
        return false;
    }
    if(password==''){
        alert("密码不能为空");
        return false;
    }
    if(!password.match(/[a-zA-Z0-9_]{4,20}/)){
        alert("密码必须为4~20位大小写字母数字下划线");
        return false;
    }
    return true;
}

function workerCheck(){
    var status = $('#status').val();
    var workername = $('#workername').val();
    if(status==''){
        alert("职工状态不能为空");
        return false;
    }
    if(!status.match(/[0-9]{0,1}/)){
        alert("职工状态格式不正确，为一位整数");
        return false;
    }
    if(workername==''){
        alert("职工姓名不能为空");
        return false;
    }
    return true;
}
function productCheck(){
    var flowerName = $('#flowerName').val();
    var price = $('#price').val();
    var number = $('#number').val();
    if(flowerName==''){
        alert("花名不能为空");
        return false;
    }
    if(price==''){
        alert("价格不能为空");
        return false;
    }
    if(!price.match(/[0-9]*[\.]{0,1}[0-9]{0,2}/)){
        alert("价格支持小数点后两位");
        return false;
    }
    if(number==''){
        alert("花种数量不能为空");
        return false;
    }
    if(!number.match(/[0-9]*/)){
        alert("花种数量只能为整数");
        return false;
    }
    return true;
}
function orderCheck(){
    var receiveName = $('#receiveName').val();
    var sendName = $('#sendName').val();
    var receiveTel = $('#receiveTel').val();
    var receiveAdd = $('#receiveAdd').val();
    var quantity = $('#quantity').val();
    if(receiveName==''){
        alert("接收人姓名不能为空");
        return false;
    }
    if(sendName==''){
        alert("订花人姓名不能为空");
        return false;
    }
    if(receiveTel==''){
        alert("接收人手机号不能为空");
        return false;
    }
    if(!receiveTel.match(/1[3,4,5,7,8]{1}[0-9]{9}/)){
        alert("接收人手机号格式不正确");
        return false;
    }
    if(receiveAdd==''){
        alert("接收人地址不能为空");
        return false;
    }
    if(quantity==''){
        alert("订购数量不能为空");
        return false;
    }
    if(!quantity.match(/[0-9]*/)){
        alert("订购数量必须为数字");
        return false;
    }
    return true;
}

function adminCheck(){
    var username = $('#username').val();
    var password = $('#password').val();
    var email = $('#email').val();
    var tel = $('#tel').val();
    var name = $('#name').val();
    var cardID = $('#cardID').val();
    var address = $('#address').val();
    if(username==''){
        alert("用户名不能为空");
        return false;
    }
    if(!username.match(/[a-zA-Z0-9_]{4,20}/)){
        alert("用户名必须为4~20位大小写字母数字下划线");
        return false;
    }
    if(password==''){
        alert("密码不能为空");
        return false;
    }
    if(!password.match(/[a-zA-Z0-9_]{4,20}/)){
        alert("密码必须为4~20位大小写字母数字下划线");
        return false;
    }
    if(email==''){
        alert("邮箱不能为空");
        return false;
    }
    if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/)){
        alert("邮箱格式不正确");
        return false;
    }
    if(tel==''){
        alert("手机号不能为空");
        return false;
    }
    if(!tel.match(/1[3,4,5,7,8]{1}[0-9]{9}/)){
        alert("手机号格式不正确");
        return false;
    }
    if(cardID==''){
        alert("身份证号不能为空");
        return false;
    }
    if(!cardID.match(/[0-9]{18}/)){
        alert("身份证号格式不正确");
        return false;
    }
    return true;
}

