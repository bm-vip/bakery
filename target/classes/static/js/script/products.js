rules = {
    productGroupSelect2: "required",
    code: "required",
    title: "required",
    amount: "required"
};

messages = {
    productGroupSelect2: resources.pleaseSelect.format(resources.productsGroup),
    code: resources.pleaseEnter.format(resources.code),
    title: resources.pleaseEnter.format(resources.title),
    amount: resources.pleaseEnter.format(resources.amount)
};

function loadEntityByInput() {
    var entity = {
        id: $("#hdf_id").val(),
        productGroup: {id: $("#productGroupSelect2").val()},
        code: $("#code").val(),
        amount: $("#amount").val(),
        title: $("#title").val()
    };
    return entity;
}

columns = [{
    data: 'title'
}, {
    data: 'code'
}, {
    data: 'productGroup.title'
}, {
    data: 'amount'
}, {
    data: 'created'
}, {
    data: 'id',
    searchable: false,
    sortable: false,
    render: function (data) {
        return "<a class='btn btn-default fa fa-pencil' id='" + data + "'></a> <a class='btn btn-danger fa fa-trash' id='" + data + "'></a>"
    }
}];

function loadInputByEntity(entity) {
    $("#hdf_id").val(entity.id);
    $("#productGroupSelect2").html("<option value='" + get(() => entity.productGroup.id) + "' selected>" + get(() => entity.productGroup.title) + "</option>").trigger('change');
    $("#productGroupSelect2").val(get(() => entity.productGroup.id)).trigger('change');
    $('#code').val(entity.code);
    $('#amount').val(entity.amount);
    $("#title").val(entity.title);
}
