import { useState } from "react";
import axios from "axios";

function LoginPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleLogin = (e) => {
        e.preventDefault();

        const params = new URLSearchParams();
        params.append("username", username.trim());
        params.append("password", password.trim());

        axios.post("/loginForm", params, {
            withCredentials: true,
            headers: { "Content-Type": "application/x-www-form-urlencoded" }
        })
            .then(() => {
                window.location.href = "/req/list";
            })
            .catch(() => {
                setError("❌ 로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
            });
    };

    return (
        <div style={{ padding: "40px" }}>
            <h2>로그인</h2>
            <form onSubmit={handleLogin}>
                <div>
                    <label>
                        아이디:
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </label>
                </div>
                <div>
                    <label>
                        비밀번호:
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </label>
                </div>
                <button type="submit">로그인</button>
                {error && <p style={{ color: "red" }}>{error}</p>}
            </form>
        </div>
    );
}

export default LoginPage;
