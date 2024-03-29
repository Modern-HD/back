const regExpPrevent = new RegExp("\.(exe|sh|bat|js|msi|dll)$\i"); // 실행파일 막기
const regExpImage = new RegExp("\.(jpg|jpeg|png|gif|webp|JPG|JPEG|PNG|GIF|WEBP)$"); // 이미지 파일만 허용
const maxSize = 2 * 1024 * 1024; // 2MB

function fileSizeAndTypeValidation(fileName, fileSize) {
    if(regExpPrevent.test(fileName)) {
        return 0;
    } else if(!regExpImage.test(fileName)) {
        return 0;
    } else if(fileSize > maxSize) {
        return 0;
    } else {
        return 1;
    }
}

document.addEventListener('change', (e) => { 
    if(e.target.id == 'files') {
        // input type file element에 저장된 file 정보를 가져오는 property, 리턴은 객체형
        const fileObjects = document.getElementById('files').files;
        console.log(fileObjects);
        let div = document.getElementById('fileZone');
        div.innerHTML = '';
        let ul = '<ul class="list-group list-group-flush">';
        
        let isOk = 1;
        for (const file of fileObjects) {
            if (document.getElementById('regBtn') != null) {
                document.getElementById('regBtn').disabled = false;
            } else if(document.getElementById('modBtn') != null){
                document.getElementById('modBtn').disabled = false;
            }
            let vaildFile = fileSizeAndTypeValidation(file.name, file.size);
            isOk *= vaildFile;
            ul += `<li class="${vaildFile ? "bg-success text-white" : "bg-danger text-white"} list-group-item d-flex justify-content-between align-items-start">`;
            ul += `<div class="ms-2 me-auto">${file.name}</div>`;
            ul += `<span class="badge bg-primary rounded-pill">${file.size}</span></li>`;
        }
        ul += '</ul>';
        div.innerHTML = ul;
        if (!isOk) {
            if (document.getElementById('regBtn') != null) {
                document.getElementById('regBtn').disabled = true;
            } else if(document.getElementById('modBtn') != null) {
                document.getElementById('modBtn').disabled = true;
            }
        }
    }
})

document.getElementById('attachTrigger').addEventListener('click', () => {
    document.getElementById('files').click();
})
