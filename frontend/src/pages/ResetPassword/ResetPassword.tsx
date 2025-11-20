import React, { useState, useEffect } from "react";
import { useNavigate, useSearchParams, Link } from "react-router-dom";
import "./ResetPassword.css"; // import CSS riêng

type ApiResponse = {
  ok: boolean;
  message?: string;
};

const ResetPassword: React.FC = () => {
  const [searchParams] = useSearchParams();
  const token = searchParams.get("token");

  const navigate = useNavigate();

  const [loading, setLoading] = useState(false);
  const [infoMessage, setInfoMessage] = useState<string | null>(null);
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  const [cccd, setCccd] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  useEffect(() => {
    setInfoMessage(null);
    setErrorMessage(null);
  }, [token]);

  const validateCCCD = (value: string) => /^\d{9,12}$/.test(value);
  const validatePassword = (p: string) => p.length >= 8;

  const handleRequestReset = async (e: React.FormEvent) => {
    e.preventDefault();
    setInfoMessage(null);
    setErrorMessage(null);

    if (!validateCCCD(cccd)) {
      setErrorMessage("Vui lòng nhập số CCCD hợp lệ (9-12 chữ số).");
      return;
    }

    try {
      setLoading(true);
      const res = await fetch("/api/auth/request-reset", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ cccd }),
      });
      const data: ApiResponse = await res.json();

      if (res.ok && data.ok) {
        setInfoMessage(
          "Nếu CCCD tồn tại, chúng tôi đã gửi link đặt lại mật khẩu."
        );
      } else {
        setErrorMessage(data.message || "Có lỗi xảy ra.");
      }
    } catch {
      setErrorMessage("Không thể kết nối server.");
    } finally {
      setLoading(false);
    }
  };

  const handleResetPassword = async (e: React.FormEvent) => {
    e.preventDefault();
    setInfoMessage(null);
    setErrorMessage(null);

    if (!token) {
      setErrorMessage("Token không hợp lệ hoặc đã hết hạn.");
      return;
    }
    if (!validatePassword(password)) {
      setErrorMessage("Mật khẩu phải có ít nhất 8 ký tự.");
      return;
    }
    if (password !== confirmPassword) {
      setErrorMessage("Mật khẩu xác nhận không khớp.");
      return;
    }

    try {
      setLoading(true);
      const res = await fetch("/api/auth/reset", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ token, password }),
      });
      const data: ApiResponse = await res.json();

      if (res.ok && data.ok) {
        setInfoMessage(
          "Đặt lại mật khẩu thành công! Chuyển hướng sang đăng nhập..."
        );
        setTimeout(() => navigate("/login"), 1500);
      } else {
        setErrorMessage(data.message || "Đặt lại mật khẩu thất bại.");
      }
    } catch {
      setErrorMessage("Không thể kết nối server.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="reset-container">
      <div className="reset-card">
        <h2 className="reset-title">
          {token ? "Đặt lại mật khẩu CCCD" : "Yêu cầu đặt lại mật khẩu CCCD"}
        </h2>

        {infoMessage && <div className="reset-info">{infoMessage}</div>}
        {errorMessage && <div className="reset-error">{errorMessage}</div>}

        {!token ? (
          <form onSubmit={handleRequestReset} className="reset-form">
            <label>Số CCCD</label>
            <input
              type="text"
              value={cccd}
              onChange={(e) => setCccd(e.target.value)}
              placeholder="Nhập số CCCD"
              required
            />
            <button type="submit" disabled={loading}>
              {loading ? "Đang gửi..." : "Gửi yêu cầu"}
            </button>
            <div className="reset-footer">
              Đã nhớ mật khẩu? <Link to="/login">Đăng nhập</Link>
            </div>
          </form>
        ) : (
          <form onSubmit={handleResetPassword} className="reset-form">
            <label>Mật khẩu mới</label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Tối thiểu 8 ký tự"
              required
            />

            <label>Xác nhận mật khẩu</label>
            <input
              type="password"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              placeholder="Nhập lại mật khẩu"
              required
            />

            <button type="submit" disabled={loading}>
              {loading ? "Đang xử lý..." : "Đặt lại mật khẩu"}
            </button>
            <div className="reset-footer">
              Quay lại <Link to="/login">đăng nhập</Link>
            </div>
          </form>
        )}
      </div>
    </div>
  );
};

export default ResetPassword;
