<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><tiles:insertAttribute name="title"/></title>
    
    
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="<c:url value="/css/sb-admin.css" />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/font-awesome/css/font-awesome.min.css" />">
    
    

    
  </head>

  <body ng-app="ecomApp">

    <div id="wrapper">
	  
	  <!-- Navbar and Sidebar -->
	  <tiles:insertAttribute name="menu"/>
      

      <div id="page-wrapper">
      	<!-- Header -->
		<tiles:insertAttribute name="header"/>
        <!-- Body -->
        <tiles:insertAttribute name="body"/>

      </div><!-- /#page-wrapper -->
      <!-- Footer -->
      <tiles:insertAttribute name="footer"/>
    </div><!-- /#wrapper -->
    
	<!-- JavaScript -->
    <script src="<c:url value="/js/jquery-1.10.2.js" />"></script>
    <script src="<c:url value="/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/js/angular-1.4.8/angular.min.js" />"></script>
    <script src="<c:url value="/js/ecomApp/ecomApp.js" />"></script>
    <script src="<c:url value="/js/ecomApp/controllers/userCtrl.js" />"></script>
    <script src="<c:url value="/js/ecomApp/controllers/cartCtrl.js" />"></script>
    
    <!-- Page Specific Plugins -->
    <script src="<c:url value="/js/tablesorter/jquery.tablesorter.js" />"></script>
    <script src="<c:url value="/js/tablesorter/tables.js" />"></script>

  </body>
</html>