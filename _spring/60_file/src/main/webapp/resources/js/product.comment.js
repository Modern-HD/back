document.addEventListener('DOMContentLoaded', () => {
    getCommentList(document.getElementById('pno').innerText);
});

async function postCommentToServer(cmtData) {
    try {
        const url = '/comment/post';
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result
    } catch (error) {
        console.log(error);
    }
}

async function spreadCommentFromServer(pno, pageNo) {
    try {
        const resp = await fetch('/comment/' + pno + "/" + pageNo); // RESTFul
        const pagingHandler = await resp.json();
        return pagingHandler;
    } catch (error) {
        console.log(error);
    }
}

async function modCommentDataToServer(cmtData) {
    try {
        const url = '/comment/' + cmtData.cno;
        const config = {
            method: 'PUT', //PATCH도 가능
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result
    } catch (error) {
        console.log(error);
    }
}

async function delCommentToServer(cmtData) {
    try {
        const url = '/comment/' + cmtData.cno;
        const config = {
            method: 'DELETE'
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result
    } catch (error) {
        console.log(error);
    }
}

if (document.getElementById('cmtSbmBtn') != null) {
    document.getElementById('cmtSbmBtn').addEventListener('click', () => {
        const cmtInputObj = document.getElementById('cmtText');
        if(cmtInputObj.value == null || cmtInputObj.value == '') {
            alert("댓글 내용을 입력해 주세요!");
            cmtInputObj.focus();
            return false;
        } else {
            let cmtData = {
                pno: document.getElementById('pno').innerText,
                writer: document.getElementById('cmtWriter').innerText,
                content: cmtInputObj.value
            };
            postCommentToServer(cmtData).then(result => {
                if(parseInt(result)) {
                    alert('댓글 등록 성공');
                    getCommentList(document.getElementById('pno').innerText);
                }
            });
        }
    })
}

document.addEventListener('click', (e) => {
    if(e.target.classList.contains('cmtModBtn')) {
        const cno = e.target.closest('tr').dataset.cno;
        const contentArea = document.querySelector(`tr[data-cno="${cno}"] > td:nth-child(2)`);
        const optionArea = document.querySelector(`tr[data-cno="${cno}"] > td:last-child`);
        contentArea.innerHTML = `<input type="text" id="modContent" value="${contentArea.innerText}" class="col-11">`;
        optionArea.innerHTML = `<button type="button" id="modSbmBtn" class="btn btn-primary">Sbm</button>
        <button type="button" id="modCelBtn" class="btn btn-outline-secondary">Cel</button>`;
    } else if(e.target.id == "modCelBtn") {
        getCommentList(document.getElementById('pno').innerText);
    } else if(e.target.id == "modSbmBtn") {
        const cno = e.target.closest('tr').dataset.cno;
        const pageNo = e.target.closest('tr').dataset.page_no;
        const content = document.getElementById('modContent').value;
        if (content == "") {
            alert("수정할 댓글 내용을 입력해주세요!");
            return;
        }
        const cmtData = {
            "cno": cno,
            "content": content
        }
        modCommentDataToServer(cmtData).then(result => {
            if(parseInt(result)) {
                getCommentList(document.getElementById('pno').innerText);
                for(let i = 2; i <= pageNo; i++) {
                    getCommentList(document.getElementById('pno').innerText, i, true);
                }
            }
        });
    } else if(e.target.classList.contains('cmtDelBtn')) {
        const cno = e.target.closest('tr').dataset.cno;
        document.getElementById('delCno').value = cno;
        document.getElementById('delModalBtn').click();
    } else if(e.target.id == 'moreCmtBtn') {
        const pageNo = e.target.dataset.page_no;
        getCommentList(document.getElementById('pno').innerText, pageNo, true);
    }
});

document.getElementById('delSbmBtn').addEventListener('click', () => {
    const cno = document.getElementById('delCno').value;
    delCommentToServer({"cno": cno}).then(result => {
        if(result > 0) {
            getCommentList(document.getElementById('pno').innerText);
        }
        document.getElementById("delCloseBtn").click();
    });
});

function getCommentList(pno, pageNo = 1, more = false) {
    spreadCommentFromServer(pno, pageNo).then(result => {
        console.log(result);
        const cmtZone = document.getElementById('cmtZone');
        let str = "";
        if (result.cmtList.length == 0) {
            str = "코멘트가 존재하지 않습니다.";
        }
        result.cmtList.forEach(el => {
            str += `<tr class="cmtTr" data-cno="${el.cno}" data-page_no="${result.pgvo.pageNo}">`;
            str += `<td>${el.writer}</td>`
            str += `<td>${el.content}</td>`;
            str += `<td>${el.regAt.substring(2, 16)}</td>`;
            if(document.getElementById('cmtSbmBtn') != null && (el.writer == document.getElementById('cmtWriter').innerText || 
                document.getElementById('cmtWriter').innerText == "admin@admin.com")) {
                str += `<td>`;
                str += `<button type="button" class="cmtModBtn btn btn-outline-warning">Mod</button> `;
                str += `<button type="button" class="cmtDelBtn btn btn-outline-danger">Del</button>`;
                str += `</td>`;
            } else {
                str += `<td></td>`
            }
            str += '</tr>';
        });
        if (result.pgvo.pageNo < result.endPage) {
            document.getElementById('moreCmt').innerHTML = `<button id="moreCmtBtn" class="btn btn-outline-primary" data-page_no="${result.pgvo.pageNo + 1}">More Comments</button>`
        } else {
            document.getElementById('moreCmt').innerHTML = "";
        }
        if (more) {
            cmtZone.innerHTML += str;
        } else {
            cmtZone.innerHTML = str;
        }
    });
}