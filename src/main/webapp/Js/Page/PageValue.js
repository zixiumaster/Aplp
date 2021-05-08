//访问界面根路径
var urlRoot="http://localhost:8080/Aplp/";

//去欢迎界面
function goWelcome(){
    var urlPath=urlRoot;
    window.open(urlRoot);
}

//去主界面
function goMajor(){
    var urlPath=urlRoot+"Major/goMajor.action";
    window.open(urlPath);
}

//获取时间戳 秒
function nowTime(){
    var myDate=Date.parse(new Date());
    myDate=myDate/1000;
    return myDate;
}

//根据jsn的key获取value
function getValue(jsonObj,key) {
    for (var item in jsonObj) {
        if (item == key) {
            return  jsonObj[item];
        }
    }

}