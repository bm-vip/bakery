rules = {
    code: "required",
    title: "required"
};

messages = {
    code: resources.pleaseEnter.format(resources.code),
    title: resources.pleaseEnter.format(resources.title)
};
function loadEntityByInput() {
    var entity = {
        id: $("#hdf_id").val(),
        code: $("#code").val(),
        title: $("#title").val()
    };
    return entity;
}
columns = [{    
    data: 'code'
}, {    
    data: 'title'
}, {
    data: 'created'
},{
    data: 'id',
    searchable: false,
    sortable: false,
    render: function (data) { return "<a class='btn btn-default fa fa-pencil' id='" + data + "'></a> <a class='btn btn-danger fa fa-trash' id='" + data + "'></a>" }
}];

function loadInputByEntity(entity) {
    $("#hdf_id").val(entity.id);
    $('#code').val(entity.code);
    $("#title").val(entity.title);
}