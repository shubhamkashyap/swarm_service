	
	function setCookie(cname, cvalue, exminutes) 
	{
	    var d = new Date();
	    d.setTime(d.getTime() + (exminutes * 60 * 1000));
	    var expires = "expires="+d.toUTCString();
	    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
	}

	function deleteCookie(cname) 
	{
	    document.cookie = cname + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;path=/';
	};
	
	function getCookie(cname) 
	{
	    var name = cname + "=";
	    var ca = document.cookie.split(';');
	    for(var i = 0; i < ca.length; i++) 
	    {
	        var c = ca[i];
	        while (c.charAt(0) == ' ') 
	        {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) 
	        {
	            return c.substring(name.length, c.length);
	        }
	    }
	    return "";
	}