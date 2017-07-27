
var totalpage;
var currentpage = 1;
$(document).ready(function() {
	
    $("#query").click(init);
    $("#dataTables").click(dataTable);
    $("#dataTablesFront").click(show);
});

function init(){

		   $.ajax({
		       type : "GET",
		       url : "./findAlls",
		       dataType:"json",
		       contentType: "application/x-www-form-urlencoded; charset=utf-8",
		       success : function(data) {
		    	   	var studentInfo = data;
		    	   	console.log(data);
		           // var studentList = studentInfo.content;		            
		          //  console.log(studentInfo);

		    	   	/* $("#student").html("");
		            $('#student').append("<caption><h4>"+"学生信息"+"</h4></caption>");
		            $('#student').append(" <thead> "+"<tr>"+
		                    "<th>"+"学号"+"</th>" +
		                    "<th>"+"姓名"+"</th>" +
		                    "<th>"+"性别"+"</th>" +
		                    "<th>"+"出生日期"+"</th>" +
		                    "<th>"+"院系"+"</th>" +
		                    "<th>"+"家庭地址"+"</th>" +
		                            "</tr>"+" </thead>");*/
		            var length = data.length;
		            for(var i=0;i<length;i++)
		                {
		                  $('#student').append("<tr>"+
		                        "<td>"+data[i].id+"</td>" +
		                        "<td>"+data[i].name+"</td>" +
		                        "<td>"+data[i].sex+"</td>" +
		                        "<td>"+data[i].birth+"</td>" +
		                        "<td>"+data[i].department+"</td>" +
		                        "<td>"+data[i].address+"</td>" +
		                                "</tr>");
		                }

		       }
		   }); 
		   
   }
function dataTable(){
	  $('#student').dataTable(
			  {
				  "oLanguage": {
				  "sLengthMenu": "每页显示 _MENU_ 条记录",
				  "sZeroRecords": "对不起，查询不到任何相关数据",
				  "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_条记录",
				  "sInfoEmtpy": "找不到相关数据",
				  "sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
				  "sProcessing": "正在加载中...",
				  "sSearch": "搜索",
				  "oPaginate": {
				  "sFirst": "第一页",
				  "sPrevious":" 上一页 ",
				  "sNext": " 下一页 ",
				  "sLast": " 最后一页 "
				  },
				    
				  },
				 // destroy:true, //Cannot reinitialise DataTable,解决重新加载表格内容问题 
				 // "bProcessing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
	               "bServerSide": true, //开启服务器模式，使用服务器端处理配置datatable。注意：sAjaxSource参数也必须被给予为了给datatable源代码来获取所需的数据对于每个画。 这个翻译有点别扭。开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。 
	               // "sAjaxSource": "./dataTableBack", //给服务器发请求的url
	               "ajax":{
	            	   url : "./dataTableBack",
	               },
	               
	               "aoColumns": [ //这个属性下的设置会应用到所有列，按顺序没有是空
	                    {"mData": 'id'}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列
	                    {"mData": 'name'},
	                    {"mData": 'sex'},
	                    {"mData": 'birth'},
	                    {"mData": 'department'},
	                    {"mData": 'address'},
	                    
	              
	                ],
				  }
	  );
}
function show(){
	$('#student').dataTable(
			{
				  "oLanguage": {
				  "sLengthMenu": "每页显示 _MENU_ 条记录",
				  "sZeroRecords": "对不起，查询不到任何相关数据",
				  "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_条记录",
				  "sInfoEmtpy": "找不到相关数据",
				  "sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
				  "sProcessing": "正在加载中...",
				  "sSearch": "搜索",
				  "oPaginate": {
				  "sFirst": "第一页",
				  "sPrevious":" 上一页 ",
				  "sNext": " 下一页 ",
				  "sLast": " 最后一页 "
				  },
				    
				  
				  }
			}		
	);
}


