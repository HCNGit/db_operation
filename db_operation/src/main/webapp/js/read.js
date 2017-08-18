
$(document).ready(function() {
    $("#up").click(upload);
    
});

function upload(){

	/*
	 * 第二种方式传文件数据，此法可传多个文件
	 * var formData = new FormData();
	formData.append('excelFile', $('#excelFile')[0].files[0]);
	*/
		   $.ajax({
		       type : "post",
		       url : "./readExcelFile",
		       data : new FormData($("#myform")[0]),   //第一种方式
		       processData: false,
		       contentType: false,
		       success : function(data) {
		    	   
		    	   console.log(data);
		    	   
				var data= eval('('+data+')');
		     	var html="";
			  html+="<table><tbody>";
			for(var i=0; i<data.length; i++){
				html+="<tr><td>"+data[i][0]+"</td><td>"+data[i][1]+"</td><td>"+data[i][2]+"</td><td>" +
				data[i][3]+"</td><td>"+data[i][4]+"</td><td>"+data[i][5]+"</td></tr>";
			}
			html+="</tbody><table>";
			$('#filedata').empty().append(html);
		       }
		   }); 

   }
