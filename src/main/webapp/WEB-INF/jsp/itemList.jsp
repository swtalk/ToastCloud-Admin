<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="tcp-ops" content="width=device-width, initial-scale=1.0">

    <title>아이템 관리</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    
    <link href="resources/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
    <link href="resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">

</head>

<body>
    <div id="wrapper">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox-content">
                        <!-- 버튼 영역 Start -->
                        <div class="row">
                            <div class="form-group">
                                <button type="button" id="buttonSearch" class="btn btn-info">
                                    <span class="glyphicon glyphicon-search"></span> Search
                                </button>
                                <button type="button" id="buttonInsert" class="btn btn-success">
                                    <span class="glyphicon glyphicon-plus-sign"></span> Insert
                                </button>
                                <button type="button" id="buttonDelete" class="btn btn-warning">
                                    <span class="glyphicon glyphicon-minus-sign"></span> Delete
                                </button>
                            </div>
                        </div>
                        <!-- 버튼 영역 End -->
                        
                        <!-- Table 영역 Start -->
                        <div class="table-responsive dataTables_wrapper">
                            <table class="table table-striped table-bordered table-hover itemTable" >
                            <thead>
                            <tr>
                                <th class="text-center">chk</th>
                                <th class="text-center" data-field="itemId">아이템 ID</th>
                                <th class="text-center" data-field="itemName">아이템 명</th>
                                <th class="text-center" data-field="price">가격</th>
                                <th class="text-center" data-filed="descn">비고</th>
                                <th class="text-center"></th>
                            </tr>
                            </thead>
                            </table>
                        </div>
                        <!-- Table 영역 End -->
                        
                    </div>
                </div>
            </div>
        </div>
            
        <!-- modal 입력창 Start -->
        <div id="modal-form" class="modal inmodal" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12"><h3 class="modal-title">아이템 등록</h3>
                                <div class="hr-line-dashed"></div>
                                <form role="form" id="frmAdd" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">아이템 ID</label>
                                        <div class="col-md-10">
                                            <input type="text" id="itemId" name="itemId" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">아이템 명</label>
                                        <div class="col-md-10">
                                            <input type="text" id="itemName" name="itemName" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">가격</label>
                                        <div class="col-md-10">
                                            <input type="text" id="price" name="price" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">비고</label>
                                        <div class="col-md-10">
                                            <input type="text" id="descn" name="descn" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="hr-line-dashed"></div>
                                    <div>
                                        <div class="form-group">
                                            <div class="col-sm-8 col-sm-offset-4">
                                                <button class="btn btn-primary" type="submit">저장</button>
                                                <button class="btn btn-white" data-dismiss="modal">취소</button>
                                        </div>
                                    </div>
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal 입력창 End -->
        
    </div>

    <!-- Mainly scripts -->
    <script src="resources/js/jquery-2.1.1.js"></script>
    <script src="resources/js/jquery.validate.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    
    <script src="resources/js/plugins/dataTables/datatables.min.js"></script>
    <script src="resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    <script src="resources/js/plugins/sweetalert/sweetalert.min.js"></script>
    
    <!-- Custom and plugin javascript -->
    <script src="resources/js/inspinia.js"></script>
    <script src="resources/js/plugins/pace/pace.min.js"></script>

    <script>
        $(document).ready(function(){
            
            $("#frmAdd").validate({
                rules: {
                    itemId: {
                        required: true,
                        minlength: 1
                    },
                    itemName: "required",
                    price: {
                        required: true,
                        number: true
                    },
                    password: {
                        required: true,
                        minlength: 5
                    }
                },
                messages: {
                    itemId: {
                        required: "아이템 ID를 입력해 주세요.",
                        minlength: "아이템 ID는 최소 1자리 이상이어야 합니다."
                    },
                    itemName: "아이템 명을 입력해 주세요.",
                    price: {
                        required: "가격을 입력해 주세요.",
                        number: "숫자만 입력 가능합니다."
                    }
                },
                errorElement: "em",
                errorPlacement: function (error, element) {
                    // Add the `help-block` class to the error element
                    error.addClass("help-block");

                    if (element.prop("type") === "checkbox") {
                        error.insertAfter(element.parent("label"));
                    } else {
                        error.insertAfter(element);
                    }
                },
                highlight: function (element, errorClass, validClass) {
                    $(element).parents(".col-md-10").addClass("has-error").removeClass("has-success");
                },
                unhighlight: function (element, errorClass, validClass) {
                    $(element).parents(".col-md-10").addClass("has-success").removeClass("has-error");
                }, submitHandler: function (form) {
                    var url = "/items";
                    var method = "POST";
                    if($("#itemId").prop("disabled")) {
                        url += "/" + $("#itemId").val();
                        method = "PUT";
                    }
                    
                    $.ajax({
                        type: method,
                        url: url,
                        timeout : 100000,
                        data: $("#frmAdd").serialize(),
                        success: function(data){
                            tableClient.clear().draw();
                            tableClient.ajax.reload();
                            swal("저장 되었습니다!", data.cnt + "건이 성공적으로 저장 되었습니다!", "success");
                        },
                        error: function(e){
                            alert("code:"+e.status+"\n"+"message:"+e.responseText);
                        }
                    });
                    $('#modal-form').modal('hide');
                }
            });
            
            var tableClient = $(".itemTable").DataTable({
                sPaginationType: 'full_numbers',
                bProcessing: true,
                pageLength: 10,
                responsive: true,
                language: {
                    emptyTable: "조회 내역이 없습니다."
                },
                columnDefs: [
                    {aTargets: [0], width: '30px'},
                    {aTargets: [0, -1], orderable: false},
                    {aTargets: [0, -1], className: 'text-center'},
                    {aTargets: [3], className: 'text-right'}
                ],
                ajax: {
                    url: '/items',
                    type: 'GET',
                    success: function(data) {
                        $.each(data, function(ind, obj){
                            tableClient.row.add([
                                "<input type='checkbox' value='"+obj.itemId+"' id=''>",
                                obj.itemId,
                                obj.itemName,
                                obj.price.toLocaleString(),
                                obj.descn,
                                "<button id='edit' class='btn btn-xs btn-primary' type='button'>Edit</button>"
                            ]).draw();
                        });
                    }
                },
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    { extend: 'copy'},
                    {extend: 'csv'},
                    {extend: 'excel', title: 'ExampleFile'},
                    {extend: 'pdf', title: 'ExampleFile'},

                    {extend: 'print',
                     customize: function (win){
                            $(win.document.body).addClass('white-bg');
                            $(win.document.body).css('font-size', '10px');

                            $(win.document.body).find('table')
                                    .addClass('compact')
                                    .css('font-size', 'inherit');
                            }
                    }
                ]

            });
            
            $("#buttonSearch").click(function(){
                tableClient.clear().draw();
                tableClient.ajax.reload();
                
            });
            
            $("#buttonInsert").click(function(){
                $('#modal-form').on('shown.bs.modal', function () {
                    $('#itemId').focus();
                })
                $("#modal-form").modal("show");
            });
            
            $(".itemTable tbody").on("click", "#edit", function (e) {
                e.preventDefault();
                var data = tableClient.row($(this).parents('tr')).data();
                var itemId = data[1];
                $("#itemId").val(itemId);
                $("#itemId").prop("disabled", true);
                $("#itemName").val(data[2]);
                $("#price").val(data[3]);
                $("#descn").val(data[4]);
                $(".modal-title").text("아이템 수정");
                $('#modal-form').on('shown.bs.modal', function () {
                    $('#itemName').focus();
                })
                $("#modal-form").modal("show");
            });
            
            $("#buttonDelete").click(function(){
                if ($(".itemTable input[type='checkbox']:checkbox:checked").length > 0) {
                    var previousWindowKeyDown = window.onkeydown;
                    swal({
                          title: "정말 삭제 하시겠습니까?",
                          text: "삭제된 건은 복구할 수 없습니다!",
                          type: "warning",
                          showCancelButton: true,
                          confirmButtonClass: "btn-danger",
                          confirmButtonText: "삭제",
                          cancelButtonText: "취소",
                          closeOnConfirm: false
                        },
                        function(){
                            window.onkeydown = previousWindowKeyDown;
                            var checkArr = [];
                            $(".itemTable input[type='checkbox']:checkbox:checked").each(function(i) {
                                checkArr.push($(this).val());
                            });
                            
                            var params = {"deleteIds": checkArr};
                            
                            $.ajax({
                                type: 'DELETE',
                                url: '/items?' + $.param(params),
                                timeout : 100000,
                                success: function(data){
                                    tableClient.clear().draw();
                                    tableClient.ajax.reload();
                                    swal("삭제 되었습니다!", data.cnt + "건이 성공적으로 삭제 되었습니다!", "success");
                                },
                                error: function(e){
                                    alert("code:"+e.status+"\n"+"message:"+e.responseText);
                                }
                            });
                        });
                } else {
                    swal("선택한 목록이 없습니다!");
                    return false;
                }
            });
            
            $('#modal-form').on('hidden.bs.modal', function () {
                $("#frmAdd")[0].reset(); // reset form on modal
                $("#itemId").prop("disabled", false);
                $(".modal-title").text("아이템 등록");
                
                // Validation 관련 초기화
                $(".col-md-10").removeClass("has-error");
                $(".col-md-10").removeClass("has-success");
                $(".help-block").each(function () { $(this).remove(); });
            });
        });
    </script>
</body>
</html>