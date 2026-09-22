import os

ids_hex = {
    '0x7f130055': 'conversation_auth_required_error',
    '0x7f1300ba': 'conversation_settings_auth_required_error',
    '0x7f130100': 'document_scanner_auth_required_error',
    '0x7f130261': 'notification_auth_error',
    '0x7f130273': 'onboarding_auth_error',
    '0x7f130290': 'setup_auth_failed_error',
    '0x7f130291': 'setup_generic_error',
    '0x7f130292': 'setup_missing_info_error',
    '0x7f130294': 'setup_session_expired_error',
    '0x7f13029b': 'sign_practice_auth_error',
    '0x7f1302e2': 'sign_video_upload_auth_error',
    '0x7f1302ed': 'speech_auth_failed_error'
}

ids_search = {}
for h, name in ids_hex.items():
    dec = str(int(h, 16))
    ids_search[h] = name
    ids_search[dec] = name
    # also with prefix
    ids_search[h.lower()] = name

for root, dirs, files in os.walk('apktool_smali'):
    for f in files:
        if f.endswith('.smali') and not f.startswith('R$'):
            p = os.path.join(root, f)
            with open(p, 'r', encoding='utf-8', errors='ignore') as fl:
                c = fl.read()
                for k, name in ids_search.items():
                    if k in c:
                        print(f'{p} uses {name} ({k})')
