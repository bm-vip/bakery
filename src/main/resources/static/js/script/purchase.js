rules = {
    count: {
        required: true,
        number: true
    },
    productsSelect2: "required"
};

messages = {
    count: {
        required: resources.pleaseEnter.format(resources.count),
        number: resources.mustBeNumber.format(resources.count)
    },
    productsSelect2: resources.pleaseSelect.format(resources.products)
};

function loadEntityByInput() {
    var entity = {
        count: $("#count").val(),
        productId: $("#productsSelect2").val()
    };
    return entity;
}

function submitForm() {
    $.blockUI(blockUiOptions());
    $.getJSON(ajaxUrl + "/calc", loadEntityByInput(), function (json) {
        $.unblockUI();
        if (json.error == null) {
            $('#total-amount').text(json.data.total);
            $('#purchase-detail').empty();
            json.data.detail.forEach(i => {
                $('#purchase-detail').append("<li><label>" + i + "</label></li>")
            });
        } else {
            show_error(json.error);
        }
    })
}