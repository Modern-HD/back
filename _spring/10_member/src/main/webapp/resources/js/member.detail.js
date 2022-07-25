document.getElementById('memberRemove').addEventListener('click', () => {
    const emailVal = document.getElementById('emVal').innerText;
    document.getElementById('em').value = emailVal;
    const delForm = document.getElementById('memberRmForm');
    delForm.setAttribute('action', '/member/remove');
    delForm.submit();
})