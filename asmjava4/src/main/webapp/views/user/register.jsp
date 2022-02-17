<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>register</title>
<%@ include file="/common/head.jsp" %>

</head>
<body>
	<%@ include file="/common/header.jsp" %>

	<div class="container-fluid tm-mt-60">
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
              <center> <h2 class="tm-text-primary mb-5">Register</h2></center>
                <form id="register-form" action="register" method="POST" class="tm-contact-form mx-auto">
                <c:if test="${not empty message}">
								<div class="row mb-3">
									<div class="alert alert-success" role="alert">${message}
									</div>
								</div>
							</c:if>
							<c:if test="${not empty error}">
								<div class="row mb-3">
									<div class="alert alert-danger" role="alert">${error}</div>
								</div>
							</c:if>
                    <div class="form-group">
                        <input type="text" name="username" class="form-control rounded-0" placeholder="username" required />
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control rounded-0" placeholder="password" required />
                    </div>
                    
                     <div class="form-group">
                        <input type="email" name="email" class="form-control rounded-0" placeholder="Email" required />
                    </div>

                    <div class="form-group tm-text-right">
                        <button type="submit" class="btn btn-primary">Send</button>
                    </div>
                </form>                
            </div>
            
             </div>
            
            
           
    </div> 
	
	<%@ include file="/common/footer.jsp" %>
	

</body>
</html>