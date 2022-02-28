Page.Value = (function() {
	var objectifier = function(splits, create, context) {
		var result = context || window;
		for (var i = 0, s; result && (s = splits[i]); i++) {
			result = (s in result ? result[s] : (create ? result[s] = {} : undefined));
		}
		return result;
	};
	return {
		//属性 ---------------------------------------------------------------------------

		//访问界面根路径 http://localhost:8080/Aplp/
		urlRoot: "http://localhost:8080/Aplp/",

		//属性 ---------------------------------------------------------------------------
		//方法 ---------------------------------------------------------------------------

		//获取时间戳 秒	
		nowTime: function() {
			var myDate = Date.parse(new Date());
			myDate = myDate / 1000;
			return myDate;
		}
		
		
		//方法 ---------------------------------------------------------------------------
	};

})();