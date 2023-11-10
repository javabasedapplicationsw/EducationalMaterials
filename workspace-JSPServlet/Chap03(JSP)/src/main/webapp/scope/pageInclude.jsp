<%@page import="kr.co.himedia.common.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>include되는 페이지</h4>
<%
	int pageInteger2 = (Integer)pageContext.getAttribute("pageInteger");
	PersonDTO pageDTO2 = (PersonDTO)pageContext.getAttribute("pageDTO");
%>

<ul>
  <li> Integer 객체 : <%= pageInteger2 %> </li>
  <li> String 객체 : <%= pageContext.getAttribute("pageString") %></li>
  <li> Person 객체 : <%= pageDTO2.getName() %>, <%= pageDTO2.getAge() %></li>
</ul>

