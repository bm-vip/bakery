var rules = {};
var messages = {};
var columns = [];
var ajaxUrl;
window.onload = function () {
    $("input,select,textarea").each(function () {
        $(this).attr("name", $(this).attr("id"));
    });

    //$('.date input,.date .input-group-addon').MdPersianDateTimePicker(datePickerOptions());

    ajaxUrl = $("#requestMapping").val();

    $('form:eq(0):not(#myModal form)').validate(validationOptions(rules, messages, function (form) {
            var fn = window["submitForm"];
            if (typeof fn === 'function') {
                fn(form);
            } else {
                fn = window["loadEntityByInput"];
                if (typeof fn === 'function') {
                    var entity = fn(true);
                    if (entity instanceof FormData) {
                        $.blockUI(blockUiOptions());
                        $.ajax({
                            type: "POST",
                            url: ajaxUrl + "/save",
                            processData: false,
                            contentType: false,
                            data: entity,
                            success: function (data) {
                                $.unblockUI();
                                if (data.error == null) {
                                    clearAll();
                                    show_success(resources.saveSuccess);
                                    $.publish('reloadTable');
                                } else {
                                    show_error(data.error);

                                }
                            },
                            error: function (header, status, error) {
                                show_error('ajax answer post returned error: ' + header + ' ' + status + ' ' + error);
                            }
                        });
                    } else {
                        $.blockUI(blockUiOptions());
                        $.post(ajaxUrl + "/save", {entity: JSON.stringify(entity)}, function (data) {
                            $.unblockUI();
                            if (data.error == null) {
                                show_success(resources.saveSuccess);
                                clearAll();
                                $.publish('reloadTable');

                            } else {
                                show_error(data.error);
                            }
                        });
                    }
                }

            }
        }
        )
    );

    $(".table:not(#myModal .table)").on("click", ".fa-pencil", function () {
        var fn = window["loadInputByEntity"];
        if (typeof fn === 'function') {
            $.blockUI(blockUiOptions());
            $.getJSON(ajaxUrl + "/findById", {id: $(this).attr("id")}, function (entity) {
                $.unblockUI();
                if (entity.error == null) {
                    if (isNullOrEmpty(entity.data)) {
                        show_warning(resources.nothingFound);
                    } else {
                        fn(entity.data);
                    }
                } else {
                    show_error(entity.error);
                }
            });
        }
    });
    $(".table:not(#myModal .table)").on("click", ".fa-trash", function (e) {
        if (confirm(resources.areYouSure)) {
            $.blockUI(blockUiOptions());
            $.post(ajaxUrl + "/deleteById", {id: $(this).attr("id")}, function (data) {
                $.unblockUI();
                if (data.error == null) {
                    $.publish("reloadTable");
                    show_success(resources.deleteSuccess);
                } else {
                    show_error(data.error);
                }
            });
        }
    });
    var onLoad = window["onLoad"];
    if (typeof onLoad === 'function') {
        onLoad();
    }
    if ($('.table:not(#myModal .table)').length > 0) {
        var dataTable = initAjaxTable('.table:not(#myModal .table)', columns, ajaxUrl + "/findAllTable", "loadEntityByInput");
        $.subscribe('reloadTable', dataTable.ajax.reload);
    }
}

function clearAll() {
    var fn = window["clearAll_"];
    if (typeof fn === 'function') {
        fn();
    } else {
        $('form').each(function (index, frm) {
            frm.reset();
        });
        $('form input:hidden:not(#myModal form input:hidden)').val('');
        $('#myModal .panel-body input,#myModal .panel-body textarea').val('');
        $("select.select2-hidden-accessible").val('').trigger('change');
        ;
    }
}