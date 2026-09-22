import re

file_path = "apktool_smali/res/values/strings.xml"
with open(file_path, "r", encoding="utf-8") as f:
    content = f.read()

replacements = [
    (r'<string name="auth_credentials_cd_logo_lts">"Let\'s Talk Sign Logo"</string>',
     r'<string name="auth_credentials_cd_logo_lts">Mouna Logo</string>'),
    (r'<string name="auth_credentials_title_screen">"Let\'sTalkSign"</string>',
     r'<string name="auth_credentials_title_screen">Mouna</string>'),
    (r'<string name="conversation_screen_title_default">"Let\'sTalkSign"</string>',
     r'<string name="conversation_screen_title_default">Mouna</string>'),
    (r'<string name="conversation_settings_community_desc">Follow the Let’sTalkSign channel on WhatsApp</string>',
     r'<string name="conversation_settings_community_desc">Follow the Mouna channel on WhatsApp</string>'),
    (r'<string name="conversation_settings_invite_desc">"Enjoying Let\'sTalkSign\? Invite others to break communication barriers"</string>',
     r'<string name="conversation_settings_invite_desc">"Enjoying Mouna? Invite others to break communication barriers"</string>'),
    (r'<string name="conversation_share_intent_text">"Hey! Checkout Let\'sTalkSign - Automatic Sign Language Interpreter\n%1\$s"</string>',
     r'<string name="conversation_share_intent_text">"Hey! Checkout Mouna - Automatic Sign Language Interpreter\n%1$s"</string>'),
    (r'<string name="global_app_name">"Let\'sTalkSign Live Interpret"</string>',
     r'<string name="global_app_name">Mouna</string>'),
    (r'<string name="global_dialog_share_desc">"Enjoying Let\'sTalkSign\? Invite others to use the app"</string>',
     r'<string name="global_dialog_share_desc">"Enjoying Mouna? Invite others to use the app"</string>'),
    (r'<string name="global_dialog_share_title">"Share Let\'sTalkSign"</string>',
     r'<string name="global_dialog_share_title">"Share Mouna"</string>'),
    (r'<string name="global_drawer_title">"Let\'sTalkSign"</string>',
     r'<string name="global_drawer_title">Mouna</string>'),
    (r'<string name="onboarding_consent_cd_logo">"Let\'sTalkSign logo"</string>',
     r'<string name="onboarding_consent_cd_logo">Mouna logo</string>'),
    (r'<string name="onboarding_consent_title_welcome">"Thanks for downloading Let\'sTalkSign\!"</string>',
     r'<string name="onboarding_consent_title_welcome">"Thanks for downloading Mouna!"</string>'),
    (r'<string name="onboarding_role_title_question">How would you like to use Let’sTalkSign\?</string>',
     r'<string name="onboarding_role_title_question">How would you like to use Mouna?</string>')
]

for pattern, repl in replacements:
    new_content, count = re.subn(pattern, repl, content)
    if count == 0:
        print(f"WARNING: pattern not found: {pattern}")
    else:
        print(f"Replaced {count} match for: {pattern[:40]}...")
    content = new_content

with open(file_path, "w", encoding="utf-8") as f:
    f.write(content)

print("Finished strings rebranding.")
