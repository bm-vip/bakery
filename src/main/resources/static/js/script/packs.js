rules = {
    productsSelect2: "required",
    packCount: "required",
    amount: "required"
};

messages = {
    productsSelect2: resources.pleaseSelect.format(resources.products),
    packCount: resources.pleaseEnter.format(resources.packCount),
    amount: resources.pleaseEnter.format(resources.amount)
};

function loadEntityByInput() {
    var entity = {
        id: $("#hdf_id").val(),
        product: {id: $("#productsSelect2").val()},
        packCount: $("#packCount").val(),
        amount: $("#amount").val()
    };
    return entity;
}

columns = [{
    data: 'packCount'
}, {
    data: 'amount'
}, {
    data: 'product.title'
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
    $("#productsSelect2").html("<option value='" + get(() => entity.product.id) + "' selected>" + get(() => entity.product.title) + "</option>").trigger('change');
    $("#productsSelect2").val(get(() => entity.product.id)).trigger('change');
    $('#packCount').val(entity.packCount);
    $('#amount').val(entity.amount);
}
