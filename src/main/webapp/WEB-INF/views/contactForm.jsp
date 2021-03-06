<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <h2>Find or contact us!</h2>
        <hr>
    </div>
    <!-- /.row -->

    <!-- Content Row -->
    <div class="row">
        <!-- Contact Details Column -->
        <div class="col-lg-12" style="text-align: center">
            <c:if test="${pageContext.request.getParameter('resultSending') == 'true'}">
                <h3 style="color:green">Email already send!</h3>
            </c:if>
            <c:if test="${pageContext.request.getParameter('resultSending') == 'false'}">
                <h3 style="color:red">Email wasn't send!</h3>
            </c:if>
            <p>
                ul.Grojecka 39<br>Warsaw, 250053<br>
            </p>
            <p><i class="fa fa-phone"></i>
                <abbr title="Phone">Phone</abbr>: (48) 533 447 056</p>
            <p><i class="fa fa-clock-o"></i>
                <abbr title="Hours">H</abbr>: Monday - Friday: 9:00 AM to 5:00 PM</p>
            <ul class="list-unstyled list-inline list-social-icons">
                <li>
                    <a href="#"><i class="fa fa-facebook-square fa-2x"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-twitter-square fa-2x"></i></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-google-plus-square fa-2x"></i></a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <hr>
            <h3>Send us an Email</h3>
            <form:form name="sentMessage" id="contactForm" action="${pageContext.request.contextPath}/email/sendMail"
                       method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Full Name:</label>
                        <input type="text" class="form-control" id="name" name="name"
                               required data-validation-required-message="Please enter your name.">
                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Phone Number:</label>
                        <input type="tel" class="form-control" id="phone" name="phone"
                               required data-validation-required-message="Please enter your phone number.">
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Email Address:</label>
                        <input type="email" class="form-control" id="email" name="email"
                               required data-validation-required-message="Please enter your email address.">
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Subject:</label>
                        <input type="text" class="form-control" id="subject" name="subject"
                               required data-validation-required-message="Please enter subject.">
                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Message:</label>
                        <textarea rows="10" cols="100" class="form-control" id="message" name="message"
                                  required data-validation-required-message="Please enter your message" maxlength="999"
                                  style="resize:none"></textarea>
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary">Send Message</button>
            </form:form>
        </div>

    </div>
    <!-- /.row -->

    <hr>
</div>
<!-- /.container -->