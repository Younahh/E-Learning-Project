<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://bootswatch.com/4/slate/bootstrap.css" rel="stylesheet">
<link href="https://bootswatch.com/4/slate/bootstrap.min.css" rel="stylesheet">
<script src="https://bootswatch.com/_vendor/jquery/dist/jquery.min.js"></script>
<script src="https://bootswatch.com/_vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>E-Learning Plateform</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="Accueil.jsp">E-Learning Plateform</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarColor01">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="Accueil.jsp">Accueil
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Accueil.jsp">General</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Accueil.jsp">Pedagogie</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Accueil.jsp">LifeCycle</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Others</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="Accueil.jsp">Object</a>
                <a class="dropdown-item" href="Accueil.jsp">Courses</a>
                <a class="dropdown-item" href="Accueil.jsp">Rights</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="Accueil.jsp">Profil</a>
              </div>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
          </form>
        </div>
    </nav>
    <div class="container">
    <form>
        <fieldset>
          <legend>Connectez-vous</legend>
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>
      </form>
    </div>
</body>
</html>