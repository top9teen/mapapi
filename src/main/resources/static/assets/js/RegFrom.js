function fncSubmit()
{

	if(document.welcome.username.value == "" )
	{
		alert('Please input Username');
		document.welcome.username.focus();
		return false;
	}	
	
	if(document.welcome.username.value == "admin")
	{
		alert('Please input Username');
		document.welcome.username.focus();
		return false;
	}	
	
	if(document.welcome.password.value == "" )
	{
		alert('Please input Password');
		document.welcome.password.focus();		
		return false;
	}	
	
	if(document.welcome.password.value == "password")
	{
		alert('Please input Password');
		document.welcome.password.focus();		
		return false;
	}	
	

	if(document.welcome.conpassword.value == "")
	{
		alert('Please input Confirm Password');
		document.welcome.conpassword.focus();		
		return false;
	}	

	if(document.welcome.password.value != document.welcome.conpassword.value)
	{
		alert('Confirm Password Not Match');
		document.form1.conpassword.focus();		
		return false;
	}	

	if(document.welcome.name.value == "")
	{
		alert('Please input Name');
		document.welcome.name.focus();		
		return false;
	}	
    if(document.welcome.name.value == "")
	{
		alert('Please input Address');
		document.welcome.address.focus();		
		return false;
    }	
    if(document.welcome.Phone.value == "")
    {
		alert('Please input Phone');
		document.welcome.Phone.focus();		
		return false;
	}
		document.welcome.submit();

    }