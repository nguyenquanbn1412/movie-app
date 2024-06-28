// Xử lý validate form
$('#form-update-user').validate({
    rules: {
        name: {
            required: true
        },
    },
    messages: {
        name: {
            required: "Tên user không được để trống"
        },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
        error.addClass('invalid-feedback');
        element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
        $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).removeClass('is-invalid');
    }
});
// Xử lý submit form
const btnUpdate = document.getElementById('btn-update');
const btnReset = document.getElementById('btn-reset-password');
const nameEl = document.getElementById('name');
const roleEl = document.getElementById('role');
btnUpdate.addEventListener('click', () => {
    if (!$('#form-update-user').valid()) return;

    const data = {
        name: nameEl.value,
        role: roleEl.value,
    }

    axios.put(`/api/admin/users/${user.id}`, data)
        .then(res => {
            toastr.success("Cập nhật thông tin thành công");
        })
        .catch(err => {
            toastr.error("Cập nhật thông tin thất bại");
        })
})
btnReset.addEventListener('click', () => {

    axios.put(`/api/admin/users/${user.id}/reset-password`)
        .then(res => {
            toastr.success("Reset mật khẩu thành công");
        })
        .catch(err => {
            toastr.error("Reset mật khẩu thất bại");
        })
})
