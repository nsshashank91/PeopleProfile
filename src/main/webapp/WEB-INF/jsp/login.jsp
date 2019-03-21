
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html>
<head>
    <title>Log in with your credentials</title>

</head>

<body>

<div class="container">

    <form method="POST" action="/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group">
            
            <input name="username" type="text"  placeholder="Username"/><br>
            <input name="password" type="password"  placeholder="Password"/><br>
            <span>${errorMsg}</span>
            <span>${msg}</span>
            
			<button type="submit">Log In</button>
        </div>
    </form>
	<a href="/register">Register New
			User</a>
		
</div>


</body>
</html>
