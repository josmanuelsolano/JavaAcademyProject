<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<tiles:insertAttribute name="header" />
 <div class="container">
  	<div class="row">
  	  <div class="col-md-1">
        <tiles:insertAttribute name="menu"/>
      </div>
      <div class="col-md-11">
      	<tiles:insertAttribute name="body"/>
      </div>
   </div>
 </div>
<tiles:insertAttribute name="footer" />
 
</body>
</html>