<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" type="text/css" href="css/tiles.css">
</head>
<body>
<tiles:insertAttribute name="header" />
 <div class="main">
  <tiles:insertAttribute name="menu" />
  <div class="rightPane">
   <tiles:insertAttribute name="body" />
  </div>
 </div>
<tiles:insertAttribute name="footer" />
 
</body>
</html>