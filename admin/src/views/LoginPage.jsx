import { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

function LoginPage() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate()

    const handleLogin = async (e) => {
        e.preventDefault()

        try {
            const params = new URLSearchParams()
            params.append('username', username)
            params.append('password', password)

            console.log('로그인 시도 중:', username, password)

            const response = await axios.post('/loginForm', params, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                withCredentials: true,
                validateStatus: () => true  // 모든 상태코드를 catch가 아닌 then에서 받게 함
            })

            if (response.status === 302 || response.status === 200) {
                // 로그인 성공 시
                navigate('/main')
            } else {
                // 로그인 실패 시
                alert('로그인 실패: 아이디 또는 비밀번호를 확인하세요.'+response.status)
            }
        } catch (err) {
            alert('요청 오류 발생')
            console.error(err)
        }
    }

    return (
        <div style={{ maxWidth: '300px', margin: '100px auto', textAlign: 'center' }}>
            <h2>로그인</h2>
            <form onSubmit={handleLogin}>
                <input
                    type="text"
                    placeholder="아이디"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                    style={{ width: '100%', padding: '8px', marginBottom: '10px' }}
                />
                <input
                    type="password"
                    placeholder="비밀번호"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                    style={{ width: '100%', padding: '8px', marginBottom: '10px' }}
                />
                <button
                    type="submit"
                    style={{ width: '100%', padding: '8px', backgroundColor: '#007bff', color: 'white', border: 'none' }}
                >
                    로그인
                </button>
            </form>
        </div>
    )
}

export default LoginPage
