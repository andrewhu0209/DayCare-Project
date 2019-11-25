
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Loding font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">

    <!-- Custom Styles -->
    <link rel="stylesheet" type="text/css" href="./css/styles.css">

    <title>Login</title>
  </head>
  <body>

    <!-- Backgrounds -->

    <div id="login-bg" class="container-fluid">

      <div class="bg-img"></div>
     
    </div>

    <!-- End Backgrounds -->

    <div class="container" id="login">
        <div class="row justify-content-center">
        <div class="col-lg-8">
          <div class="login">

            <h1>Login</h1>
            
            <!-- Loging form -->
                  <form action="login.do" method="post">
                    <div class="form-group">
                      <input type="text" class="form-control" id="exampleInputEmail1"  placeholder="Enter user name" name="username">
							<% String msg = (String)request.getAttribute("msg"); %>
							<span style="color: red; font-size: 20px"> ${msg}</span>
							
						</div>
                    <div class="form-group">
                      <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pwd">
                    </div>


                  
                    <br>
                    <button type="submit" class="btn btn-lg btn-block btn-success">Sign in</button>
                  </form>
             <!-- End Loging form -->

          </div> <h2 style="color:black"><strong>DayCare Center</strong></h2>
        </div>
        </div>
    </div>


  </body>
</html>