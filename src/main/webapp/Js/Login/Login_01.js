//验证码的值
var VerificationCode;

function loginOnclick() {
	checkVerificationCode()
	
}
 function checkVerificationCode(){
	 //获取验证码的值
	 var vCBtnText = VerificationCode;
	 
	 //获取验证码输入框的值
	 var vCInput = document.getElementById("vc");

	 //判断验证码是否输入正确
	 if (vCBtnText.toLowerCase()==vCInput.value.toLowerCase()){
		 
		//验证码输入框清空
		vCInput.value="";
		
		//改变验证码
		change();
	  	alert("验证码输入正确");
		return true;
	 }else{
		vCInput.value="";
		change();
	 	alert("验证码输入错误");
		return false;
	 }
 }
 
 