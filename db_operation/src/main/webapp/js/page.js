
var totalpage;
var currentpage = 1;
$(document).ready(function() {
    $("#query").click(show);
    $("#queryByAddress").click(queryByAddr);
    
    $("#prev").click(function(){
    
        if (currentpage == 1) {  
            alert("已经是第一页了！");  
            return;
        }

        currentpage--;
        $("#currentpage").val(""+currentpage);
        show();
       // queryByAddr();
    });
    
    $("#next").click(function(){
    //    var num = $("#currentpage").val();

        if (currentpage == totalpage) {  
            alert("已经是最后一页了！");  
            return;
        }
        currentpage++;
        $("#currentpage").val(""+currentpage);
        show();
       // queryByAddr();

    });
    
    $("#tail").click(function(){
        
    	currentpage=totalpage;
        $("#currentpage").val(""+totalpage);
        show();
       // queryByAddr();
    });
    
});

function show(){
    var info = {
       "page" : --currentpage
   };
    $.ajax({
	       type : "GET",
	       url : "./findStudentByPage",
	       data : info,
	       dataType:"json",
	       contentType: "application/x-www-form-urlencoded; charset=utf-8",
	       success : function(data) {
	    	   var studentInfo = data;
	    	    console.log(data);
	            var studentList = studentInfo.content;
	            
	       //     console.log(studentInfo);

	            currentpage++;
	        //    currentpage++;
	            totalpage = studentInfo.totalPages;
	            $('#totalpage').html(""+totalpage);
	            $('#currentpage').val(""+currentpage);
	            $("#student").html("");
	            $('#student').append("<caption><h4>"+"学生信息"+"</h4></caption>");
	            $('#student').append("<tr>"+
	                    "<th>"+"学号"+"</th>" +
	                    "<th>"+"姓名"+"</th>" +
	                    "<th>"+"性别"+"</th>" +
	                    "<th>"+"出生日期"+"</th>" +
	                    "<th>"+"院系"+"</th>" +
	                    "<th>"+"家庭地址"+"</th>" +
	                            "</tr>");
	            var length = studentList.length;
	            for(var i=0;i<length;i++)
	                {
	                  $('#student').append("<tr>"+
	                        "<td>"+studentList[i].id+"</td>" +
	                        "<td>"+studentList[i].name+"</td>" +
	                        "<td>"+studentList[i].sex+"</td>" +
	                        "<td>"+studentList[i].birth+"</td>" +
	                        "<td>"+studentList[i].department+"</td>" +
	                        "<td>"+studentList[i].address+"</td>" +
	                                "</tr>");
	                }

	       }
	   }); 
}

function queryByAddr(){
	//currentpage = 1;
	 var info = {
		       "page" : --currentpage,
		       "address" : $("#address").val()
		   };
		   $.ajax({
		       type : "GET",
		       url : "./findStudentByAddress",
		       data : info,
		       dataType:"json",
		       contentType: "application/x-www-form-urlencoded; charset=utf-8",
		       success : function(data) {
		    	   	var studentInfo = data;
		            var studentList = studentInfo.content;
		            
		            console.log(studentInfo);

		            currentpage++;
		            totalpage = studentInfo.totalPages;
		            $('#totalpage').html(""+totalpage);
		            $('#currentpage').val(""+currentpage);
		            $("#student").html("");
		            $('#student').append("<caption><h4>"+"学生信息"+"</h4></caption>");
		            $('#student').append("<tr>"+
		                    "<th>"+"学号"+"</th>" +
		                    "<th>"+"姓名"+"</th>" +
		                    "<th>"+"性别"+"</th>" +
		                    "<th>"+"出生日期"+"</th>" +
		                    "<th>"+"院系"+"</th>" +
		                    "<th>"+"家庭地址"+"</th>" +
		                            "</tr>");
		            var length = studentList.length;
		            for(var i=0;i<length;i++)
		                {
		                  $('#student').append("<tr>"+
		                        "<td>"+studentList[i].id+"</td>" +
		                        "<td>"+studentList[i].name+"</td>" +
		                        "<td>"+studentList[i].sex+"</td>" +
		                        "<td>"+studentList[i].birth+"</td>" +
		                        "<td>"+studentList[i].department+"</td>" +
		                        "<td>"+studentList[i].address+"</td>" +
		                                "</tr>");
		                }

		       }
		   }); 

   }

